const   express         = require('express'),
        app             = express(),
        bodyParser      = require('body-parser'),
        operations      = require("./operations"),
        DateCalculator  = require("./DateCalculator"),
        session         = require("express-session"),
        mongoose        = require("mongoose"),
        mongoStore      = require('connect-mongo')(session)


mongoose.connect("mongodb://localhost:27017/dateCalculator")
.then(() => {
    console.log("Connected to Date-Calculator DB")
})
.catch((err) => {
    console.log(err)
})

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())
        
app.use(session({
    secret: "date_calculator",
    resave: false,
    saveUninitialized: false,
    store: new mongoStore({mongooseConnection: mongoose.connection})
    // store: new mongoStore({mongooseConnection: mongoose.connection}),
    // cookie: {maxAge: 24*60*60*1000}
}))


app.set("view engine", "ejs")
        
app.get("/", (req, res) => {
    console.log(req.session)
    let operations = req.session.operations || [];
    
    req.session.operations = operations;
    return res.render("home", {result: "" || null , operations: req.session.operations})
})

app.post("/", (req, res) => {
    console.log(req.body)
    let calculator = new DateCalculator(req.body.inputDate)
    let result = calculator.operations(req.body.operation, req.body.operationValue);
    let operations = req.session.operations || [];
    let sessionOperation = (req.body.operationValue || '') + " " + req.body.operation + " " + result;
    operations.unshift(sessionOperation);
    req.session.operations = operations;
    return res.render("home", {result: result || null, operations: req.session.operations})
})

app.listen(process.env.PORT || 3000, () => {
    console.log("server is listening")
})