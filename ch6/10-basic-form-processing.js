const express = require('express')
const expressHandlebars = require('express-handlebars').engine
const bodyParser = require('body-parser')
const app = express()

//the following is needed to use views 
app.engine('handlebars', expressHandlebars({defaultLayout:'main'}))
app.set('view engine','handlebars')

//this necessary to parse from respones
app.use(bodyParse.urlencoded({extended:false}))

app.get('/thank-you',(req,res)=>res.render('10-thank-you'))

// se the views / 10-home.hbs
app.get('*', (req,res)=>res.render('10-home'))



app.post('/process-contact', (req, res) => {
    console.log(`received contact from ${req.body.name}
   <${req.body.email}>`)
    res.redirect(303, '10-thank-you')
   })
   
   //the following is needed to use views 
app.engine('handlebars',expressHandlebars({defaultLayout:'main'}))
app.set('view engine','handlebars')