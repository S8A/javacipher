# JavaCipher

Tool for encrypting and decrypting text using various classical ciphers.

- Three ciphers implemented: [Atbash](https://en.wikipedia.org/wiki/Atbash), 
  [Caesar](https://en.wikipedia.org/wiki/Caesar_cipher) and 
  [Vigenère](https://en.wikipedia.org/wiki/Vigenère_cipher)
- Graphical user interface using JavaFX. GUI structure is defined in a FXML 
  file, separating presentation from program logic.
- Multiplatform: Runs on any operating system with Java 8 installed.
- TODO: Internationalisation.


## Download

Get the latest JavaCipher executable from my website and run it: 
[Download JAR](https://s8a.github.io/downloads/javacipher-latest.jar)

Requires Java 8 to run. Download Java from the 
[official website](https://java.com) or install using your package manager.


## Install with Maven

```
git clone https://github.com/S8A/javacipher.git
cd javacipher
mvn install
```

Then you can run the JAR or any of the compiled classes in the `target` 
directory.
