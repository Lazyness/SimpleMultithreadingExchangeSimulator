# Exchange Simulator

## Preview
1. This project uses jdk 8;
2. Result program you can see in console.
3. We use in project multithreading.
4. The input values   are set in the code and describe the shares, which are traded on the stock exchange:
```java   
    Share shares1 = new Share("AAPL", 100, 141);
    Share shares2 = new Share("COKE", 1000, 387);
    Share shares3 = new Share("IBM", 200, 137);
   ```
5. 
## Features
☑️Main screen with buttons:
- Ask a question,
- Settings,
- Quit;

<br>☑️Settings screen that allows you to edit user information:
- name (text field),
- last name (text field),
- date of birth (display in text, change the date using DatePickerDialog),
- gender (RadioButton);

<br>☑️Screen for questions:
- the user enters a question and clicks the "Generate" button,
- the program responds with one of the following options: "Yes", "No", "Of course", "Maybe", "Are you sure?", "Great", "Wonderful", "Right?", "Maybe we should not?", "Please, repeat", "No more words, silence", "Are you sleeping now?", "Don't know", "Who cares"
- the answer is generated based on the following data: entered question, information about user, current date.
- for the same input data, the answer must be the same.

## Launch guide
To run this project you will need to install this project in phone with Android Operating System.

## Program testing
### Main Menu
![Main Menu](app/src/main/res/img/main.jpg)