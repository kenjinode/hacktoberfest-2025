import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error
import matplotlib.pyplot as plt

def simple_linear_regression():
    # Generate sample data (e.g., house sizes vs. prices)
    np.random.seed(42)
    X = np.random.rand(100, 1) * 10  # House sizes (in 1000 sq ft)
    y = 3 * X.reshape(-1) + 2 + np.random.randn(100) * 0.5  # Prices (in $100k)

    # Split data into training and testing sets
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    # Initialize and train the model
    model = LinearRegression()
    model.fit(X_train, y_train)

    # Make predictions
    y_pred = model.predict(X_test)

    # Calculate mean squared error
    mse = mean_squared_error(y_test, y_pred)

    # Print results
    print(f"Model Coefficients: {model.coef_}")
    print(f"Model Intercept: {model.intercept_}")
    print(f"Mean Squared Error: {mse:.2f}")

    # Plot the results
    plt.scatter(X_test, y_test, color='blue', label='Actual')
    plt.plot(X_test, y_pred, color='red', label='Predicted')
    plt.xlabel('House Size (1000 sq ft)')
    plt.ylabel('Price ($100k)')
    plt.title('Linear Regression: House Size vs Price')
    plt.legend()
    plt.show()

if __name__ == "__main__":
    simple_linear_regression()
  
