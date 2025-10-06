import numpy as np
from sklearn.datasets import load_wine
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, classification_report
from sklearn.preprocessing import StandardScaler
import matplotlib.pyplot as plt

def knn_wine():
    # Load the Wine dataset
    wine = load_wine()
    X = wine.data
    y = wine.target

    # Scale the features (important for KNN)
    scaler = StandardScaler()
    X_scaled = scaler.fit_transform(X)

    # Split data into training and testing sets
    X_train, X_test, y_train, y_test = train_test_split(X_scaled, y, test_size=0.3, random_state=42)

    # Initialize and train the KNN model
    model = KNeighborsClassifier(n_neighbors=5)
    model.fit(X_train, y_train)

    # Make predictions
    y_pred = model.predict(X_test)

    # Calculate accuracy
    accuracy = accuracy_score(y_test, y_pred)

    # Print results
    print(f"Accuracy: {accuracy:.2f}")
    print("\nClassification Report:")
    print(classification_report(y_test, y_pred, target_names=wine.target_names))

    # Visualize the effect of different k values
    k_values = range(1, 21)
    accuracies = []
    
    for k in k_values:
        temp_model = KNeighborsClassifier(n_neighbors=k)
        temp_model.fit(X_train, y_train)
        temp_pred = temp_model.predict(X_test)
        accuracies.append(accuracy_score(y_test, temp_pred))

    # Plot accuracy vs k
    plt.plot(k_values, accuracies, marker='o')
    plt.xlabel('Number of Neighbors (k)')
    plt.ylabel('Accuracy')
    plt.title('KNN Model Accuracy vs. Number of Neighbors')
    plt.grid(True)
    plt.show()

if __name__ == "__main__":
    knn_wine()
