from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello_world():
        
    print("Esto es una prueba")
    return "Hello World!"