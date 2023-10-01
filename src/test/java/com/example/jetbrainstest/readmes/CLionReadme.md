## Description test cases for Clion

### Активна кнопка скачивания на главной странице CLion (downloadButtonCheckMainPage)
1. Открыть https://www.jetbrains.com/clion/
2. Проверить, что кнопка загрузки активна

### Активна кнопка скачивания на странице загрузки CLion (downloadButtonCheckDownloadPage)
1. Открыть https://www.jetbrains.com/clion/
2. Кликнуть по кнопке Download
3. Проверить, что кнопка загрузки активна

### Активна кнопка скачивания файла в формате zip (checkButtonInZipFormat)
1. Открыть https://www.jetbrains.com/clion/
2. Кликнуть по кнопке Download
3. Кликнуть по кнопке .exe
4. Проверить, что кнопка .zip активна

### Активна кнопка 'what's new' (checkIfwhatIsNewButtonClickable)
1. Открыть https://www.jetbrains.com/clion/
2. Проверить, что кнопка 'what's new' активна

### Воспроизведение видео соответсвующее программе CLion (playerCheck)
1. Открыть https://www.jetbrains.com/clion/
2. Кликнуть по фрейму с видео
3. Переключиться на фрейм
4. Получить заголовок видио
5. Проверить, что заголовок видио соответсвует заголовку "CLion Quick Tour"

### Активны кнопки из блока Follow Us (followButtonsCheck)
1. Открыть https://www.jetbrains.com/clion/
2. Проверить, что **каждая** кнопка активна

### Возможность повторного ввода валидного email спустя 2 минуты (enterTwoTimesValidEmail)
1. Открыть https://www.jetbrains.com/clion/
2. Ввести email в разделе Follow us
3. Кликнуть Submit
4. Подождать 2 минуты
5. Обновить страницу
6. Ввести email
7. Проверить, что высветилось сообщение "Thanks for your request!"

### Ввод пустого email (enterEmptyEmail)
1. Открыть https://www.jetbrains.com/clion/
2. В поле email ввести пустоту в разделе Follow us
3. Кликнуть Submit
4. Проверить, что высветилось сообщение "This field is required."

### Ввод нев ttps://www.jetbrains.com/clion/
2. Ввести невалидный email в разделе Follow us
3. Кликнуть Submit
4. Проверить, что высветилось сообщение "Please enter a valid email address."

### Смена языка страницы на русский (changeLanguageOfPage)
1. Открыть https://www.jetbrains.com/clion/
2. Найти кнопку для смены языка и кликнуть
3. Клинкуть на кнопку "Русский"
4. Проверить, что открылась страница https://www.jetbrains.com/ru-ru/clion/

### В разделе 'Code analysis on the fly' есть три фото (checkScreenshotFromCodeAnalysisSection)
1. Открыть https://www.jetbrains.com/clion/
2. Найти все скрины из раздела 'Code analysis on the fly'
3. Определить количество скрино
4. Проверить, что скринов 3 штуки

### Отображение загловока в окне с инструкций по установке (checkIfInstructionHeaderTextIsDisplayed)
1. Открыть https://www.jetbrains.com/clion/
2. Кликнуть по кнопке Download
3. Кликнуть по кнопку Instruction
4. Проверить, что заголовок отображается