# Blog Web Application

## Vision:

A public-facing blog application, allowing users of X Co. products to discuss new products and features 

+ A way for the company to engage with its customers, and  learn what they like and don´t like.
+ A company administrator posts ideas on a web site related to new products or features.
+ A running user commentary appears with each posting.

<img src="https://github.com/ayoubfalah/blog/blob/master/main/resources/META-INF/userinterface.jpg">

## Requirements: 

+ There are two types of users: the blog administrator and blog users.
+ The blog administrator should be able able to enter new postings, appearing in reverse chronological order.
+ Users should be able to visit the blog site, and enter comments about particular postings.
+ The blog administrator should be able to modify/ remove any posting or comment.
+ Users should not be able to modify postings or other users´ comments.

## Iteration #1:
Create the blog application and demonstrate that you can perform CRUD operations on posts and comments.

## CEO´s feedback for the result of the first Iteration:
The CEO of X Co. was happy with the result of the first iteration. However she forgot to discuss one thing
with me at our first meeting. She had like the name of authors to appear beside each of their posts and 
comments. Here is what she sketched:

<img src="https://github.com/ayoubfalah/blog/blob/master/main/resources/META-INF/userinterface1.1.jpg">

## Iteration #2:
Extending the blog application by a user model and demonstrate that you can perform CRUD operations on it.

## Iteration #3:
Adding data validations:
+ User: The first name and last name can not be blank
+ Post: The title and description can not be blank
+ Comment: Each comment must have a user id and post id
