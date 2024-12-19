
from flask import Flask, render_template, request, redirect, session
import sqlite3

app = Flask(__name__)
app.secret_key = 'secret_key'

def get_db_connection():
    conn = sqlite3.connect('database.sqlite3')
    conn.row_factory = sqlite3.Row
    return conn

@app.route('/')
def index():
    if 'user_id' in session:
        return redirect('/post_announcement')
    return redirect('/login')

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        username = request.form['username']
        password = request.form['password']
        conn = get_db_connection()
        user = conn.execute('SELECT * FROM users WHERE username = ? AND password = ?', (username, password)).fetchone()
        conn.close()
        if user:
            session['user_id'] = user['id']
            return redirect('/post_announcement')
        return 'Invalid credentials'
    return render_template('login.html')

@app.route('/post_announcement', methods=['GET', 'POST'])
def post_announcement():
    if 'user_id' not in session:
        return redirect('/login')
    if request.method == 'POST':
        title = request.form['title']
        content = request.form['content']
        conn = get_db_connection()
        conn.execute('INSERT INTO announcements (user_id, title, content) VALUES (?, ?, ?)', (session['user_id'], title, content))
        conn.commit()
        conn.close()
        return 'Announcement posted!'
    return render_template('post_announcement.html')

if __name__ == '__main__':
    app.run(debug=True)
