# Zmojify
Zmojify aims to be a lightweight, efficient means of finding emoji natively on desktop.

Currently the program only supports a CLI interface written in java but in the future I hope it will become graphical (possibly based on electron).

## Current Features
 * Multilingual Search

## //TODO
 * ~~Update README.md~~
 * List by frequency of use.
 * List by category.
 * ~~List available languages~~
 * Retrieve keywords by cldrShortName and emojiChar
 * Add comments
 * ommit emojis without font support

## Usage
```bash
usage:  java -jar zmojify.jar <operation> <language> <query>
operations:
    java -jar zmojify.jar {-h --help}
    java -jar zmojify.jar {-s --search} <language> <query>
    java -jar zmojify.jar {-z --zmojify-search} <language> <query>
    java -jar zmojify.jar {-l --list-languages}
```
e.g.
```bash
java -jar zmojify.jar --search en 100
```
Output:
`💯`

### Languages
A list of the available languages can be found using the `-l` or `--list-languages` operation.

For Example:

```
de ---> German
ru ---> Russian
ar ---> Arabic
```
etc.

## Acknowledgments
The language .xml files are not created by me but can be found on the [Unicode Consortium](http://www.unicode.org/repos/cldr/tags/latest/common/annotations/) website
