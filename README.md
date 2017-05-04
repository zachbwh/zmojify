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
java -jar zmojiboard.jar --search *language* *search string*
```
OR
```bash
java -jar zmojiboard.jar -s *language* *search string*

e.g.
```bash
java -jar zmojiboard.jar --search en 100
```
Output:
`💯`

### Languages
A list of the available languages can be extracted from the .xml filenames.
For Example:
de ---> German
ru ---> Russian
ar ---> Arabic
etc.
