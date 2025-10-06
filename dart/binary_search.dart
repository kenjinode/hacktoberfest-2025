int binarySearch(List<int> arr, int target) {
  int left = 0, right = arr.length - 1;

  while (left <= right) {
    int mid = left + ((right - left) ~/ 2); // midpoint

    if (arr[mid] == target) {
      return mid; // found at index mid
    }

    if (arr[mid] < target) {
      left = mid + 1; // search right half
    } else {
      right = mid - 1; // search left half
    }
  }

  return -1; // not found
}

void main() {
  // Binary search requires a sorted list
  List<int> numbers = [1, 3, 5, 7, 9, 11, 15, 20, 25];

  int target = 11;
  int result = binarySearch(numbers, target);

  if (result != -1) {
    print("Element $target found at index $result");
  } else {
    print("Element $target not found in the list");
  }

  // Try with another number
  int target2 = 4;
  int result2 = binarySearch(numbers, target2);

  if (result2 != -1) {
    print("Element $target2 found at index $result2");
  } else {
    print("Element $target2 not found in the list");
  }
}
