package com.nish.myfarmapp

data class AnimalResponse(
    val errorCode:String,
    val message:String,
    val response:List<Responses>
)

data class Responses(
   val id:String,
   val name:String,
   val tag_number:String,
   val type:String,
   val breed :String,
   val image:String,
   val age:String,
   val gender:String,
   val weight:String,
   val available:String,
   val color:String
)

