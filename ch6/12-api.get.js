const tours = [
    { id: 0, name: 'Hood River', price: 99.99 },
    { id: 1, name: 'Oregon Coast', price: 149.95 },
   ]
   app.get('/api/tours', (req, res) => res.json(tours))
