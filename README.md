# Quest-App-Backend

This projects provide us to share basic posts based on texts. We can create new user, we can create new post and comments which belong to its own post. Front-End and Security will be added later

Database Schema <br><br>

![image](https://github.com/muhammedsametakgul/Quest-App-Backend/assets/93324656/a86e8b7b-b7f0-4166-a0e3-0d4ede527936)


# Technologies/Framework/Tools
--------------------------------
* Spring Framework
* Spring Boot
* MySQL
* Lombok
* JPA/Hibernate
    * Mappings(ManyToOne)
* Postman
* Spring Web
   * Restful API


# Function URL

<h2>User</h2>
/user -> getAllUser()

/user/{userid} -> deleteUser() and updateUser()


<h2>Post</h2>
/post -> getAllPost() and savePost() <br>

/post?userid=id -> getAllPost(Based on User ID) <br>
/post/{post} -> getOnePost()


<h2>Comment</h2>
/comment?postid=id -> getAllCommentsByPostId()

/comment -> saveComment() <br>
/comment/{commentid} -> deleteComment() and updateComment()
