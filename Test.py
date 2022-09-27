def makeTranspoMatrix(plainText, keyword):
    plainText = plainText.replace(' ', '')
    matrix = []
    row = []
    count = 0

    for char in plainText:
        row.append(char)
        count += 1

        if count % len(keyword) == 0:
            matrix.append(row)
            row = []

    if len(plainText) % len(keyword) != 0:
        while len(row) != len(keyword):
            row.append('X')

        matrix.append(row)

    return matrix

def columnTranspoEncrypt(plainText, keyword):

    matrix = makeTranspoMatrix(plainText, keyword)
    sorted_keyword = ''.join(sorted(keyword))

    cipherText = []
    indices = []

    for char in sorted_keyword:
        indices.append(keyword.find(char))

    for i in indices:
        for row in matrix:
            cipherText.append(row[i])

    return ''.join(cipherText)

def columnTranspoDecrypt(cipherText, keyword):
    matrix = []
    row = []
    count = 0

    number_of_rows = len(cipherText) // len(keyword)

    for char in cipherText:
        row.append(char)
        count += 1

        if count % number_of_rows == 0:
            matrix.append(row)
            row = []

    indices = []
    sorted_keyword = ''.join(sorted(keyword))

    for char in keyword:
        indices.append(sorted_keyword.find(char))

    plainText = []

    for i in range(number_of_rows):
        for row_index in indices:
            row = matrix[row_index]

            if row[i] != 'X':
                plainText.append(row[i])

    return ''.join(plainText)

print('------Column Transposition Cipher------')

plaintext = input('Enter the Message to be Encrypted: ')
keyword = input('Enter keyword: ')

encryptedWord = columnTranspoEncrypt(plaintext, keyword)

print('\nThe Encrypted Word is:', encryptedWord)
print('The Decrypted Word is:',
      columnTranspoDecrypt(encryptedWord, keyword))
