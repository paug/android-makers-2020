# Write a blog post

  If you want to write a blog post, a few steps are required:

## 1. Write your post in [Markdown format](https://guides.github.com/features/mastering-markdown/#GitHub-flavored-markdown).

  If you're not confortable with this format, you can use a markdown editor like [StackEdit.io](https://stackedit.io/).

## 2. Add images to your post

  - Add a main image of `size: 1800*900px` in `/images/posts/my-post.jpg` where `my-post` is a really short title.
  - Add all other images with a `width: 1800px` in `/images/posts/my-post-x.jpg` where `x` is `1 .. n`.
  - In the blog post, **add the images by adding this line**:
  ```html
  <plastic-image alt=\"title of your image\" srcset=\"/images/posts/my-post-x.jpg\" lazy-load preload fade></plastic-image>
  ```

## 3. Save your post

  Save your markdown blog post in `/data/posts/YYYY-MM-DD-my-post.md` where `YYYY-MM-DD` is the current date, and `my-post` is your really short title.

## 4. Convert your post in a 1 line html format

  - Use a markdown to html converter like [Browserling](https://www.browserling.com/tools/markdown-to-html).
  - Convert your blog post in markdown to html.
  - Make sure to add a backslash before **every double-quote**: `\"`.
  - Remove every line break in order to have the whole blog post in html, **on 1 line**.

## 5. Add your post in the firebase configuration json

  Add this element in the `blog` element of your `firebase-data.json` file:
  ```json
    "my-post" : {  // <-- really short title
      "backgroundColor" : "#3647a5", // <-- main color for the placeholders
      "brief" : "This great article will tell you everything you need to know about the life, universe, and everyhting. Bring your own towel for this...", // <-- not formatted beginning of your blog post, or really short description (~130 char.)
      "content" : "<h1>A life, Universe and Everything blog post</h1><p>This great article will tell you everything you need to know about the life, universe, and everyhting. Bring your own towel for this journey</p><plastic-image alt=\"title of your image\" srcset=\"/images/posts/my-post-x.jpg\" lazy-load preload fade></plastic-image>", // <-- html 1 line version of your blog post
      "image" : "/images/posts/my-post.jpg", // <-- main image of your blog post
      "published" : "YYYY-MM-DD", <-- current date
      "source" : "/data/posts/YYYY-MM-DD-my-post.md", // <-- path to the markdown file
      "title" : "My great post about the universe" // <-- Title of your blog post
    }
  ```

## 6. Publish

  - Build and deploy your website
  - Update your firebase database
