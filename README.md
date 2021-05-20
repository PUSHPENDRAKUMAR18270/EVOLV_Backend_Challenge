## Database
- MySQL
## Reasons for MySQL
- Relational Data: Blogs and Comments are related to each other by OneToMany Relation i.e one blog can
  have many comments and relational data is better handled using RDBMS.
- Joins: Joins are required to retrieve all comments on a blog which are efficient using MySQL compared to NoSQL
- Foreign Key constraints: If blog is deleted all its corresponding comments are deleted using foreign key constraints. Higher
  consistency in data is achieved using MySQL.
## API Endpoints
### Blogs
- GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /blogs
  <details>
       <summary>Details</summary>
       <p>
            <b>Action</b><br/>
            fetches all the blogs
       </p>
  </details>
- GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /blogs/{blogId}
    <details>
         <summary>Details</summary>
         <p>
    <b>PathVariable</b><br/> 
            blogId -> Id of the blog to be fetched.
            <br/>
          <b>Action</b><br/>
          fetch a blog with id blogId
     </p>
  </details>
- POST &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /blogs
  <details>
       <summary>Details</summary>
       <p>
            <b>RequestBody</b><br/>
            <pre>
                {
                    "title":"Title of the blog(required)",
                    "content":"Content of the blog(required)",
                    "summary":"key highlights of the blog(optional)"
                }
            </pre>
            <b>Action</b><br/>
            Adds a blog to database
        </p>
  </details>
- DELETE &nbsp; /blog/{blogID}
  <details>
       <summary>Details</summary>
       <p>
            <b>PathVariable</b><br/> 
            blogId -> Id of the blog to be deleted.
            <br/>
            <b>Action</b><br/>  
            Deletes the blog with id blogId
        </p>
  </details>
- PUT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /blog/{blogId}
    <details>
       <summary>Details</summary>
        <p>
            <b>PathVariable</b><br/> 
            blogId -> Id of the blog to be updated.
            <br/>
            <b>RequestBody</b><br/>
            <pre>
                {
                    "title":"Title of the blog(optional)",
                    "content":"Content of the blog(optional)",
                    "summary":"key highlights of the blog(optional)"
                }
            </pre>
            <b>Action</b><br/>
            Updates the blog with id blogId.
        </p>
    </details>

### Comments
- GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /blogs/{blogId}/comment
    <details>
       <summary>Details</summary>
       <p>
            <b>PathVariable</b><br/> 
            blogId -> Id of the blog whose comments are to be fetched
            <br/>
            <b>Action</b><br/>
            fetches all the comments of the blog with id blogId
       </p>
    </details>
- POST &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/blogs/{blogId}/comment
    <details>
       <summary>Details</summary>
        <p>
            <b>PathVariable</b><br/> 
            blogId -> Id of the blog to be commented.
            <br/>
            <b>RequestBody</b><br/>
            <pre>
                {
                    "content":"comment(required)",
                    "parentCommentId":"Id of the parent comment(optional)"
                }
            </pre>
            <b>Action</b><br/>
            Adds a comment to blog with id blogId.
        </p>
    </details>

## Database Schema
### blogs Table Schema

```
    blog_id	        bigint AI PK
    title	        varchar(255)
    content	        longtext
    date_of_publish	datetime
    last_updated	datetime
    summary	        longtext
    
    indexes
    1) {blog_id}
```
### comments Table Schema

```
    comment_id	       bigint AI PK
    content	       longtext
    created_at	       datetime
    parent_comment_id  bigint
    blog_id	       bigint FK reference blogs.blog_id
    
    indexes:
    1) {comment_id}
    2) {blog_id}
```
## Testing
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/06642f3d9a597f07b7ee)
****