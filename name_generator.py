import random

def generate_random_name():
    """
    Generate a random full name by combining a first name and a last name.
    Returns a string with the format 'First Last'.
    """
    # Lists of common first and last names
    first_names = [
        "James", "Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia",
        "Michael", "Isabella", "Alexander", "Mia", "Daniel", "Charlotte", "Henry",
        "Amelia", "Joseph", "Harper", "David", "Evelyn"
    ]
    
    last_names = [
        "Smith", "Johnson", "Brown", "Taylor", "Wilson", "Davis", "Clark", "Lewis",
        "Walker", "Hall", "Allen", "Young", "King", "Wright", "Scott", "Green",
        "Baker", "Adams", "Nelson", "Carter"
    ]
    
    # Randomly select first and last names
    first = random.choice(first_names)
    last = random.choice(last_names)
    
    return f"{first} {last}"

def main():
    # Generate and print 5 random names as an example
    print("Generated Random Names:")
    for _ in range(5):
        name = generate_random_name()
        print(name)

if __name__ == "__main__":
    main()
  
