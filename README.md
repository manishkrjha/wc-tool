# wc-tool

A simple command-line utility written in Java and Spring Boot that replicates the functionality of the Unix `wc` (word count) command, following the challenge described at [Coding Challenges](https://codingchallenges.fyi/challenges/challenge-wc).

---

## 🧩 Overview

`wc-tool` (short for **Word Count Tool**) is a command-line utility that mimics the behavior of the classic Unix `wc` command. It counts lines, words, bytes, and characters from a given input file or standard input.

This project was created as part of the [Coding Challenges](https://codingchallenges.fyi/challenges/challenge-wc) series to deepen understanding of file handling, command-line parsing, and performance optimization using Java.

---

## ⚙️ Features

* Count **bytes** (`-c`)
* Count **lines** (`-l`)
* Count **words** (`-w`)
* Count **characters** (`-m`)
* Default mode (`wc <file>`) prints lines, words, and bytes
* Works with **stdin** (e.g. `cat test.txt | wc-tool -l`)
* Simple, modular, and easily extendable design

---

## 🚀 Usage

```bash
# Count bytes in a file
$ java -jar wc-tool.jar -c test.txt

# Count lines in a file
$ java -jar wc-tool.jar -l test.txt

# Count words in a file
$ java -jar wc-tool.jar -w test.txt

# Count characters in a file
$ java -jar wc-tool.jar -m test.txt

# Default (lines, words, bytes)
$ java -jar wc-tool.jar test.txt

# Read from stdin
$ cat test.txt | java -jar wc-tool.jar -l
```

---

## 🧱 Implementation Notes

* Uses efficient buffered reading for performance.
* Supports reading from files or standard input.
* Handles UTF-8 characters properly for accurate character counting.
* Follows the same output order as the Unix `wc` command (`lines words bytes filename`).

---

## 🧪 Testing

Use the `test.txt` sample file (from the challenge prompt) to verify correctness.

```bash
java -jar wc-tool.jar -c test.txt
java -jar wc-tool.jar -l test.txt
java -jar wc-tool.jar -w test.txt
java -jar wc-tool.jar -m test.txt
java -jar wc-tool.jar test.txt
```

Compare with:

```bash
wc -c test.txt
wc -l test.txt
wc -w test.txt
wc -m test.txt
wc test.txt
```

---

## 🏗️ Build & Run

```bash
# Clone this repository
git clone https://github.com/your-username/wc-tool.git
cd wc-tool

# Build with Maven
mvn clean package

# Run
java -jar target/wc-tool.jar <options> <file>
```

---

### 🧠 Challenge Reference

Built for the [Coding Challenges – Build your own wc](https://codingchallenges.fyi/challenges/challenge-wc) project.
