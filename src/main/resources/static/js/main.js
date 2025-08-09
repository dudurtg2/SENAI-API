/**
 * SENAI API - Main JavaScript File
 * Handles common functionality across all pages
 */

$(document).ready(function() {
    // Initialize components
    initializeNavigation();
    initializeAnimations();
    initializeFormValidation();
    initializeTooltips();
    
    console.log('SENAI API - Frontend loaded successfully');
});

/**
 * Navigation functionality
 */
function initializeNavigation() {
    // Mobile menu toggle (for future mobile implementation)
    $('.mobile-menu-toggle').on('click', function() {
        $('.navbar').toggleClass('show');
    });
    
    // Smooth scroll for anchor links
    $('a[href^="#"]').on('click', function(event) {
        var target = $(this.getAttribute('href'));
        if (target.length) {
            event.preventDefault();
            $('html, body').stop().animate({
                scrollTop: target.offset().top - 80
            }, 1000);
        }
    });
    
    // Add active class to current page navigation
    var currentPage = window.location.pathname;
    $('.navbar a').each(function() {
        var href = $(this).attr('href');
        if (href === currentPage || (currentPage === '/' && href === '/')) {
            $(this).addClass('active');
        }
    });
}

/**
 * Initialize animations
 */
function initializeAnimations() {
    // Intersection Observer for fade-in animations
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };
    
    const observer = new IntersectionObserver(function(entries) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('fade-in-up');
                observer.unobserve(entry.target);
            }
        });
    }, observerOptions);
    
    // Observe elements for animation
    $('.card, .feature-item, .section-title').each(function() {
        observer.observe(this);
    });
}

/**
 * Form validation
 */
function initializeFormValidation() {
    $('form').on('submit', function(e) {
        var isValid = true;
        var form = $(this);
        
        // Clear previous validation styles
        form.find('.form-control').removeClass('is-invalid is-valid');
        form.find('.invalid-feedback').remove();
        
        // Validate required fields
        form.find('[required]').each(function() {
            var field = $(this);
            var value = field.val().trim();
            
            if (!value) {
                isValid = false;
                showFieldError(field, 'Este campo é obrigatório.');
            } else {
                field.addClass('is-valid');
            }
        });
        
        // Validate email fields
        form.find('input[type="email"]').each(function() {
            var field = $(this);
            var value = field.val().trim();
            
            if (value && !isValidEmail(value)) {
                isValid = false;
                showFieldError(field, 'Por favor, insira um e-mail válido.');
            }
        });
        
        // Validate phone fields
        form.find('input[type="tel"]').each(function() {
            var field = $(this);
            var value = field.val().trim();
            
            if (value && !isValidPhone(value)) {
                isValid = false;
                showFieldError(field, 'Por favor, insira um telefone válido.');
            }
        });
        
        if (!isValid) {
            e.preventDefault();
            // Scroll to first error
            var firstError = form.find('.is-invalid').first();
            if (firstError.length) {
                $('html, body').animate({
                    scrollTop: firstError.offset().top - 100
                }, 500);
                firstError.focus();
            }
        }
    });
}

/**
 * Show field validation error
 */
function showFieldError(field, message) {
    field.addClass('is-invalid');
    var feedback = $('<div class="invalid-feedback">' + message + '</div>');
    field.after(feedback);
}

/**
 * Email validation
 */
function isValidEmail(email) {
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

/**
 * Phone validation (Brazilian format)
 */
function isValidPhone(phone) {
    // Remove non-digit characters
    var cleanPhone = phone.replace(/\D/g, '');
    // Check if it's a valid Brazilian phone (10 or 11 digits)
    return cleanPhone.length >= 10 && cleanPhone.length <= 11;
}

/**
 * Initialize tooltips and other UI enhancements
 */
function initializeTooltips() {
    // Simple tooltip implementation
    $('[data-tooltip]').on('mouseenter', function() {
        var tooltip = $(this).attr('data-tooltip');
        var tooltipElement = $('<div class="custom-tooltip">' + tooltip + '</div>');
        $('body').append(tooltipElement);
        
        var offset = $(this).offset();
        tooltipElement.css({
            position: 'absolute',
            top: offset.top - tooltipElement.outerHeight() - 10,
            left: offset.left + ($(this).outerWidth() / 2) - (tooltipElement.outerWidth() / 2),
            backgroundColor: '#333',
            color: 'white',
            padding: '8px 12px',
            borderRadius: '4px',
            fontSize: '14px',
            zIndex: 1000,
            pointerEvents: 'none'
        });
    }).on('mouseleave', function() {
        $('.custom-tooltip').remove();
    });
}

/**
 * Loading state management
 */
function showLoading(element) {
    element.addClass('loading');
    element.find('.btn').prop('disabled', true);
}

function hideLoading(element) {
    element.removeClass('loading');
    element.find('.btn').prop('disabled', false);
}

/**
 * API call helper functions
 */
const API = {
    baseUrl: window.location.origin,
    
    get: function(endpoint, callback, errorCallback) {
        $.ajax({
            url: this.baseUrl + endpoint,
            method: 'GET',
            dataType: 'json',
            success: callback,
            error: errorCallback || this.defaultErrorHandler
        });
    },
    
    post: function(endpoint, data, callback, errorCallback) {
        $.ajax({
            url: this.baseUrl + endpoint,
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: callback,
            error: errorCallback || this.defaultErrorHandler
        });
    },
    
    defaultErrorHandler: function(xhr, status, error) {
        console.error('API Error:', {xhr, status, error});
        showAlert('Erro ao processar solicitação. Tente novamente.', 'danger');
    }
};

/**
 * Alert/notification system
 */
function showAlert(message, type = 'info', duration = 5000) {
    var alertClass = 'alert-' + type;
    var alertId = 'alert-' + Date.now();
    
    var alertHtml = `
        <div id="${alertId}" class="alert ${alertClass} alert-dismissible fade show" role="alert" style="
            position: fixed;
            top: 20px;
            right: 20px;
            z-index: 9999;
            min-width: 300px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        ">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">×</button>
        </div>
    `;
    
    $('body').append(alertHtml);
    
    // Auto-hide after duration
    setTimeout(function() {
        $('#' + alertId).fadeOut(300, function() {
            $(this).remove();
        });
    }, duration);
}

/**
 * Format utility functions
 */
const Format = {
    /**
     * Format phone number to Brazilian standard
     */
    phone: function(phone) {
        var cleaned = phone.replace(/\D/g, '');
        if (cleaned.length === 11) {
            return cleaned.replace(/(\d{2})(\d{5})(\d{4})/, '($1) $2-$3');
        } else if (cleaned.length === 10) {
            return cleaned.replace(/(\d{2})(\d{4})(\d{4})/, '($1) $2-$3');
        }
        return phone;
    },
    
    /**
     * Format date to Brazilian standard
     */
    date: function(dateString) {
        if (!dateString) return '';
        var date = new Date(dateString);
        return date.toLocaleDateString('pt-BR');
    },
    
    /**
     * Format date and time to Brazilian standard
     */
    datetime: function(dateString) {
        if (!dateString) return '';
        var date = new Date(dateString);
        return date.toLocaleDateString('pt-BR') + ' ' + date.toLocaleTimeString('pt-BR', {
            hour: '2-digit',
            minute: '2-digit'
        });
    }
};

/**
 * Debounce function for search inputs
 */
function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

/**
 * Global error handler
 */
window.onerror = function(message, source, lineno, colno, error) {
    console.error('Global error:', {message, source, lineno, colno, error});
    return false; // Let default error handling continue
};

/**
 * Service Worker registration (for future PWA implementation)
 */
if ('serviceWorker' in navigator) {
    window.addEventListener('load', function() {
        // Service worker registration would go here
        console.log('Service Worker support detected');
    });
}