while True:
    mode = input("\nEnter mode:\n"
                 "e = Encrypt\n"
                 "d = Decrypt\n"
                 "q = Quit\n"
                 "Choice: ").lower().strip()

    if mode == "q":
        break

    elif mode == "e":
        plaintext = input("Enter plaintext: ")
        key = int(input("Enter key: "))

        ciphertext = ""

        for letter in plaintext:
            if letter.isalpha(): # Checks if its a number or letter then letter is converted into ASCII number
                ciphertext += chr((ord(letter.upper()) - 65 + key) % 26 + 65)
            else:
                ciphertext += letter

        print("Ciphertext:", ciphertext)

    elif mode == "d":
        ciphertext = input("Enter ciphertext: ")

        for key in range(26):
            plaintext = ""

            for letter in ciphertext:
                if letter.isalpha():
                    plaintext += chr((ord(letter.upper()) - 65 - key) % 26 + 65)
                else:
                    plaintext += letter

            print("Key", key, ":", plaintext)

    else:
        print("Error: Invalid choice. Please try again.")