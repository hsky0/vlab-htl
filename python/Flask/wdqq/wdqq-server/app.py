from flask import Flask, render_template, request
from flask_socketio import SocketIO


app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret!'
socketio = SocketIO(app)

@app.route('/')
def hello_world():
    return render_template("index.html")


@socketio.on("connect")
def connect():
    print("ip: " + request.remote_addr)
    print("sid: " + request.sid)

@socketio.on("htl")
def htl(data):
    print(data)
    return {"result" : "success"}

if __name__ == "__main__":
    socketio.run(app)



