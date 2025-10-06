<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Simple Calculator</title>
  <style>
    /* Basic reset and font */
    body {
      margin: 0;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      background: #f4f4f4;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    /* Calculator container */
    .calculator {
      width: 280px;
      background: #fff;
      padding: 20px;
      border-radius: 15px;
      box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
      user-select: none;
    }

    /* Display input */
    #display {
      width: 100%;
      height: 50px;
      font-size: 1.5rem;
      text-align: right;
      padding: 10px 15px;
      margin-bottom: 15px;
      border: none;
      border-radius: 8px;
      background-color: #eee;
      color: #333;
      box-sizing: border-box;
    }

    /* Buttons grid */
    .buttons {
      display: grid;
      grid-template-columns: repeat(4, 1fr);
      gap: 12px;
    }

    /* General button styling */
    button {
      padding: 18px 0;
      font-size: 1.2rem;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      background-color: #ddd;
      color: #333;
      transition: background-color 0.3s ease;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      user-select: none;
    }

    button:hover,
    button:focus {
      background-color: #bbb;
      outline: none;
    }

    /* Special buttons */
    .clear {
      background-color: #f44336;
      color: white;
      font-weight: bold;
    }

    .clear:hover,
    .clear:focus {
      background-color: #d32f2f;
    }

    .equal {
      background-color: #4caf50;
      color: white;
      font-weight: bold;
      grid-column: span 2;
    }

    .equal:hover,
    .equal:focus {
      background-color: #45a049;
    }

    /* Zero button spanning 2 columns */
    .zero {
      grid-column: span 2;
    }
  </style>
</head>
<body>
  <div class="calculator" role="region" aria-label="Simple Calculator">
    <input
      type="text"
      id="display"
      aria-label="Calculator display"
      disabled
      autocomplete="off"
      spellcheck="false"
      readonly
    />

    <div class="buttons">
      <button type="button" class="clear" aria-label="Clear" onclick="clearDisplay()">C</button>
      <button type="button" aria-label="Divide" onclick="appendValue('/')">÷</button>
      <button type="button" aria-label="Multiply" onclick="appendValue('*')">×</button>
      <button type="button" aria-label="Subtract" onclick="appendValue('-')">−</button>

      <button type="button" aria-label="7" onclick="appendValue('7')">7</button>
      <button type="button" aria-label="8" onclick="appendValue('8')">8</button>
      <button type="button" aria-label="9" onclick="appendValue('9')">9</button>
      <button type="button" aria-label="Add" onclick="appendValue('+')">+</button>

      <button type="button" aria-label="4" onclick="appendValue('4')">4</button>
      <button type="button" aria-label="5" onclick="appendValue('5')">5</button>
      <button type="button" aria-label="6" onclick="appendValue('6')">6</button>
      <button type="button" aria-label="Decimal point" onclick="appendValue('.')">.</button>

      <button type="button" aria-label="1" onclick="appendValue('1')">1</button>
      <button type="button" aria-label="2" onclick="appendValue('2')">2</button>
      <button type="button" aria-label="3" onclick="appendValue('3')">3</button>
      <button type="button" class="equal" aria-label="Equals" onclick="calculate()">=</button>

      <button type="button" class="zero" aria-label="0" onclick="appendValue('0')">0</button>
    </div>
  </div>

  <script>
    const display = document.getElementById('display');

    // Append pressed button value to the display
    function appendValue(value) {
      if (display.value === 'Error') {
        display.value = '';
      }
      display.value += value;
    }

    // Clear the display
    function clearDisplay() {
      display.value = '';
    }

    // Calculate the expression in the display
    function calculate() {
      try {
        // Prevent calculation of empty string
        if (!display.value) return;

        // Evaluate the expression safely
        const result = Function('"use strict";return (' + display.value + ')')();
        display.value = result;
      } catch {
        display.value = 'Error';
      }
    }
  </script>
</body>
</html>
