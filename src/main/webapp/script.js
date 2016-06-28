window.addEventListener('load', function() {
  'use strict';
  const ul = document.querySelector('#entryList');
  fetch('/java_blog/blog/entries').then(function(resp) {
    return resp.json();
  }).then(function(json) {
    for (var obj of json) {
      const li = document.createElement('li');
      li.appendChild(document.createTextNode(obj.title));
      li.appendChild(document.createTextNode(':'));
      li.appendChild(document.createTextNode(obj.body));
      ul.appendChild(li);
    }
  });
  const form = document.querySelector('#postForm');
  const inTitle = document.querySelector('#inTitle');
  const inBody = document.querySelector('#inTitle');
  const inAuthor = document.querySelector('#inAuthor');
  const postBtn = document.querySelector('#postBtn');
  form.addEventListener('submit', function(ev) {
    ev.preventDefault();
    const data = JSON.stringify({
      author: inAuthor.value,
      title: inTitle.value,
      body: inBody.value,
      date: new Date(Date.now())
    });
    fetch('/java_blog/blog/entries', {
      method: 'POST',
      body: data
    }).then(function(resp) {
      return resp.text();
    }).then(function(text) {
      console.log(text);
      if (text === 'ok') {
        window.alert('success');
      } else {
        window.alert('fail');
      }
    }).catch(function(err) {
      console.log(err);
      window.alert('fail');
    });
  });
});