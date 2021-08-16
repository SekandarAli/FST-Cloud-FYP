package com.example.fstsignin.Vendor

class Vendor_Model {

        lateinit var name : String
        lateinit var image : String
        lateinit var location : String
        lateinit var contact : String


constructor(){}
        constructor(Name : String,image : String, Location : String, Contact : String)
        {
            this.name = Name
            this.image = image
            this.location = Location
            this.contact = Contact
        }

    }