const express = require('express')
const expresshandlebars    = require('express-handlebars').engine
const app  = express()
//the following is needed to use views
app.engine('handlebars', expresshandlebars({defaultLayout:'main'}))
app.set('view engine','handlebars')

//see the view.error.hbs 
app.get('bad-bad-not-good',(req,res)=>
{
    throw new Error("that didn't go well!")
})

app.get('*', (req,res)=> res.render('08-click-here'))

app.use((err, req, res, next)=>{
    console.log('** Serve Error: '+err.message)
    res.status(500).render('08-error',{message:"you shoudn't have clicked that !"})

})
// this should appear AFTER all of your routes
// note that even if you don't need the "next" function, it
// included for Express to recognize this as an error handler
const port  = process.env.PORT || 3000 
 app.listen(port, ()=> console.log( `\nnavigate to http:\\localhost:${port}/headers\n`))