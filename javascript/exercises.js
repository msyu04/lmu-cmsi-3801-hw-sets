import { open } from "node:fs/promises"

export function change(amount) {
  if (!Number.isInteger(amount)) {
    throw new TypeError("Amount must be an integer")
  }
  if (amount < 0) {
    throw new RangeError("Amount cannot be negative")
  }
  let [counts, remaining] = [{}, amount]
  for (const denomination of [25, 10, 5, 1]) {
    counts[denomination] = Math.floor(remaining / denomination)
    remaining %= denomination
  }
  return counts
}

// Write your first then lower case function here
export function firstThenLowerCase(a, p) {
  return a.find(p)?.toLowerCase();
}

// Write your powers generator here
export function* powersGenerator({ofBase, upTo}) {
  let exponent = 0;
  while (true) {
    let limitTest = ofBase ** exponent;
    if (limitTest > upTo) break;
    yield limitTest
    exponent += 1
  }
}

// Write your say function here
export function say(word = null) {
  let createdString = [];

  function nextWord(newWord = null) {
    if (newWord === "") {
      createdString.push("");  // Add a space instead of an empty string
      return nextWord;
    }

    if (newWord) {
      createdString.push(newWord);
      return nextWord;
    } else {
      return createdString.join(" ");  // Join with space
    }
  }

  return nextWord(word);  // Start the chain with the initial word
}

// Write your line count function here

// Write your Quaternion class here
