package com.badr.graphql

import NetworkFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import documents.AllProductsQuery
import documents.fragment.ProductDetails
import io.reactivex.android.schedulers.AndroidSchedulers


class MainActivity : AppCompatActivity() {

    lateinit var apolloClient: ApolloClient
    lateinit var allProductsQuery: AllProductsQuery
    private var productsList = ArrayList<ProductDetails>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apolloClient = ApolloClient.builder()
                .serverUrl("YOUR URL")
                .okHttpClient(NetworkFactory.getOkHttpObject())
                .build()
        allProductsQuery = AllProductsQuery
                .builder()
                .build()

        /// first way to get data from Graph-Ql
//        val gitAllProductsCall = apolloClient
//                .query(allProductsQuery)
//        gitAllProductsCall.enqueue(object : ApolloCall.Callback<AllProductsQuery.Data>() {
//            override fun onResponse(response: Response<AllProductsQuery.Data>) {
//                val data = response.data()
//                Log.i("Hello",data.toString())
//            }
//
//            override fun onFailure(e: ApolloException) {
//                Log.i("Hello",e.toString())
//            }
//        })

        /// Second way to get data from Graph-Ql using rx2Apollo

        Rx2Apollo.from(apolloClient
                .query(AllProductsQuery
                        .builder()
                        .build()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    for (item in 1..it.data()!!.list_products().size) {
                        Log.i("Hello", "Product id is :" + it.data()!!.list_products().get(item).fragments().productDetails().id()
                                + "\n product name is " + it.data()!!.list_products().get(item).fragments().productDetails().name())
                    }
                }, {
                    Log.i("Hello", it.message)
                })
    }
}

