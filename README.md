### PhotoCloud App

## Part 1

General Demo Information:

- Information about each user (Username,Password,User Type)
1. Admin, Admin, Admin
2. EmirhanS, emrs123, Professional
3. BKarga, BahaKarga3765, Free
4. witcher312, tossacoin, Professional
5. Saraa, 123456789, Free
6. trevor90, 19901990tr, Free
7. Mhawkins21, MHawk192123, Professional
8. pauvanas, paulavanas2001, Hobbyist
9. DemirciUmut, UmutUmut123, Hobbyist

These are current users (one of them is admin user which have permission to do everything he/she
want. He/She can remove everyone’s photos, comments and also he/she can change people’s
profile informations) and all of them have more personal informations and they are stored in
users.txt file in Project folder. They also have unique profile photos for each.1
Application usage information (In that part, describe how to use your application. You can add
screenshots of the required steps that a user should follow.)

● To start the application, you need to run the main method stored in the Main.java which stored
in “./src/main/Main”.

● When you run the main code, you will see the login page. As shown in this photo, there are 2
options which you can login with your username and password or go to register page.

If you are a new user, you need to register. So, when you click register button you will see a
page requesting some personal info and also username and password which you will use to
log in. And if you accidently go into this page, you can go back to login page with login button
whenever you want.

- When you log in, you will see your profile page. At this page you have multiple choices.
  From this page, you can go to Discover Page, Search Page. Also, you can upload photos and
  edit your profile from this page. And lastly, you can log out and go to login page again.

● Discover Page: In this page, you can see others uploaded photos and you can click
whichever photo you want to see bigger and to like or dislike or send comment to the post.

● Search Page: In this page, you can see other people’s profile and go into their profile. Also
you can search people by their username.

● Uploading Photos and Applying Filters: In this application, you can upload photo from
which page you want. You only need to click the plus button at the bottom and you are
directed to Photo Upload page. In this page you will see another plus icon, an add effects
button, a description field and a post button.

● To upload a photo, you only need to press plus icon and select which photo you want, type
description if you want, add some effects if you want also and press post.

- Add Effects Page: In this page you can add effects to your photo within your user type’s
    borders. After you choose which effect you want, you click apply effects, and then save
    button to save changes. There is an example of Hobbyist User adding effects to his photo:


## Part 2

Project Design Description:

● Files and Contents:
In application’s code, there are 4 packages. Here are their names and their contents:

1. main: This package contains Main and UserDatabase files which starts program to
    work properly. UserDatabase creates new ArrayLists for users in every boot of
    program. Main creates a new user database and opens the login frame to start the
    program.
2. user: This package contains 4 sub-class and 1 super-class. The super-class is User
    class and sub-classes are Administrator, Free, Hobbyist, Professional. UserDatabase
    from main package uses the classes in this package to create ArrayList.
3. page: In this package, there are many GUI components. These are: LoginPage,
    RegisterPage, HomePage, SearchPage, EditProfilePage, PhotoPage, ProfileInfoPage.
    All of these pages services different pages with different variables.
4. image: This package contains the files which made the effects to photos.
5. userInfo: And lastly this userInfo folder have users post counts, follower counts,
    posts (as .png file), comments on these posts, likes and dislikes on these posts etc.

   ## References

https://docs.oracle.com/javase/tutorial/2d/images/saveimage.html

https://stackoverflow.com/questions/15053214/converting-an-imageicon-to-a-bufferedimage

https://www.javatpoint.com

https://netbeans.apache.org/
