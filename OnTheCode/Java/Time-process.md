# Time process



## Covent *String* to *Data*



```Java
String string = "January 2, 2010";
DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
Date date = format.parse(string);
System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
```







### Reference:

https://stackoverflow.com/questions/4216745/java-string-to-date-conversion

