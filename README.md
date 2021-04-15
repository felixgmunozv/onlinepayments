# onlinepayments
Ejercicio de sistema de pago en linea
# Servicios

#Post Save
http://localhost:8080/onlinepayments/api/bill/
{
    "idUser": 1,
    "productsQuantitys": [
        {
            "productId": 1,
            "quantity": 2
        },{
            "productId": 2,
            "quantity": 4
        }
    ]
}

#Put Update
http://localhost:8080/onlinepayments/api/bill/1
{
    
    
    "productsQuantitys": [
        {
            "productId": 3,
            "quantity": 1
        },{
            "productId": 2,
            "quantity": 5
        }
    ]
}

#Put BillCancel
http://localhost:8080/onlinepayments/api/bill/cancelar/1

#Get Bill
http://localhost:8080/onlinepayments/api/bill/1

#Get BillDetail
http://localhost:8080/onlinepayments/api/billDetail/1
