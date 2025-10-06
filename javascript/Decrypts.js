// Decrypts a string by shifting digits backward by the given shift value
function digitShiftDecrypt(input, shift) {
  return input.replace(/\d/g, digit => {
    const original = parseInt(digit, 10);
    const decrypted = (original - shift + 10) % 10; // wrap around 0-9
    return decrypted;
  });
}

// Example usage:
const encryptedMessage = "8412"; // Suppose original was "7301" with shift = 1
const shift = 1;

const decrypted = digitShiftDecrypt(encryptedMessage, shift);
console.log("Decrypted:", decrypted); // Output: "7301"
``
