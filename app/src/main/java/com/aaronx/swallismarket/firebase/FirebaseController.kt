package com.aaronx.swallismarket.firebase

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aaronx.swallismarket.data.Order
import com.aaronx.swallismarket.data.Product
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseController {
    @SuppressLint("StaticFieldLeak")
    val db = FirebaseFirestore.getInstance()

    var listOrders = MutableLiveData<List<Order>>()
    var listProducts = MutableLiveData<List<Product>>()

    fun getProducts(): LiveData<List<Product>> = listProducts
    fun getOrders(): LiveData<List<Order>> = listOrders


    fun getListOrders(context: Context){
        db.collection("Order")
            .get()
            .addOnSuccessListener { querySnapshot ->run{
                if (!querySnapshot.isEmpty) {
                    var list:List<Order>? = querySnapshot.toObjects(Order::class.java)
                    listOrders.value = list
                }else{
                    val text = "You haven't the order"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, text, duration)
                    toast.show()
                }
            }
            }
            .addOnFailureListener { exception ->run{
                Log.w("FIRESTORE", "Error getting documents $exception")
                val text = "Out Connexion"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }
            }
    }

    fun getListProducts(context: Context){
        db.collection("Product")
            .get()
            .addOnSuccessListener { querySnapshot ->run{
                if (!querySnapshot.isEmpty) {
                    var list:List<Product>? = querySnapshot.toObjects(Product::class.java)
                    listProducts.value = list
                }else{
                    val text = "You haven't the order"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, text, duration)
                    toast.show()
                }
            }
            }
            .addOnFailureListener { exception ->run{
                Log.w("FIRESTORE", "Error getting documents $exception")
                val text = "Out Connexion"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }
            }
    }

    fun postOrder(order: Order, context:Context){
        db.collection("Order").document(order.idOrder)
            .set(order)
            .addOnSuccessListener {

                //createNotification(order,"Pharmacy",context)

                Toast.makeText(context, "Success Upload", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { Toast.makeText(context, "Failed Upload", Toast.LENGTH_SHORT).show()}
    }



}