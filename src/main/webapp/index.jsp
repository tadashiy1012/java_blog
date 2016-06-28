<!doctype html>
<html>
<head>
  <meta charset="utf-8" />
  <title>java blog-sys sample</title>
</head>
<body>
  <h1>java blog-sys sample</h1>
  <h2>recent entries</h2>
  <ul id="entryList">
  </ul>
  <h2>post entry</h2>
  <form id="postForm" action="/blog/entries" method="post">
    <label for="title">tilte</label><br />
    <input type="text" name="title" id="inTitle" /><br />
    <label for="body">body</label><br />
    <textarea name="body" cols="30" rows="10" id="inBody"></textarea><br />
    <input type="hidden" name="author" value="yama" id="inAuthor" />
    <input type="submit" value="post" id="postBtn" />
  </form>
  <script src="script.js"></script>
</body>
</html>