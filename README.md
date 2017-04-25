# Zmojiboard
Zmojiboard aims to be a lightweight, effiecient means of finding emoji natively on desktop.

Currently the program only supports a CLI interface written in java but in the future I hope it will become graphical (possibly based on electron).

## Current Features
 * Multilingual Search

## //TODO
 * ~~Update README.md~~
 * List by frequency of use.
 * List by category.
 * List available languages
 * Retrieve keywords by cldrShortName and emojiChar
 * Add comments
 * Support multiple types of queries.

## Usage
```bash
java -jar Zmojiboard.jar search *language* *query*`
````

e.g.
```bash
java -jar Zmojiboard.jar search en 100
```
Output:
`💯`
