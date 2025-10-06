def validate_password(password):
    """
    Validate a password based on the following criteria:
    - At least 8 characters long
    - Contains at least one uppercase letter
    - Contains at least one lowercase letter
    - Contains at least one digit
    - Contains at least one special character (!@#$%^&*()_+-=[]{}|;:,.<>?)
    - No spaces allowed
    Returns a tuple: (is_valid: bool, message: str)
    """
    # Define criteria
    min_length = 8
    special_chars = "!@#$%^&*()_+-=[]{}|;:,.<>?"
    
    # Initialize flags
    has_upper = False
    has_lower = False
    has_digit = False
    has_special = False
    has_space = False
    
    # Check for spaces
    if ' ' in password:
        has_space = True
    
    # Check each character for criteria
    for char in password:
        if char.isupper():
            has_upper = True
        elif char.islower():
            has_lower = True
        elif char.isdigit():
            has_digit = True
        elif char in special_chars:
            has_special = True
    
    # Check all conditions
    if len(password) < min_length:
        return False, "Password must be at least 8 characters long"
    if has_space:
        return False, "Password cannot contain spaces"
    if not has_upper:
        return False, "Password must contain at least one uppercase letter"
    if not has_lower:
        return False, "Password must contain at least one lowercase letter"
    if not has_digit:
        return False, "Password must contain at least one digit"
    if not has_special:
        return False, "Password must contain at least one special character (!@#$%^&*()_+-=[]{}|;:,.<>?)"
    
    return True, "Password is valid!"

# Example usage
def main():
    test_passwords = [
        "Password123!",    # Valid
        "pass123!",       # Too short
        "password123!",    # No uppercase
        "PASSWORD123!",    # No lowercase
        "Passwordabc!",    # No digit
        "Password123",     # No special character
        "Pass word123!",   # Contains space
        "Str0ngP@ssw0rd"  # Valid
    ]
    
    for pwd in test_passwords:
        is_valid, message = validate_password(pwd)
        print(f"Password: {pwd}")
        print(f"Valid: {is_valid}, Message: {message}\n")

if __name__ == "__main__":
    main()
  
