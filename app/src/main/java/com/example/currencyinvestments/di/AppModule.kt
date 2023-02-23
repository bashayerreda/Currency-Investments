package com.example.currencyinvestments.di

import com.example.currencyinvestments.common.Constants
import com.example.currencyinvestments.data.remote.CoinsApiInterface
import com.example.currencyinvestments.data.repository.CoinRepositoryImp
import com.example.currencyinvestments.domain.repository.CoinRepository
import com.example.currencyinvestments.domain.use_cases.get_coins.InvokeSortedCoins
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun returnRetrofitInstance(): CoinsApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CoinsApiInterface::class.java)
    }




   @Provides
    @Singleton
    fun provideCoinsRepoImp(coinsApiInterface: CoinsApiInterface) : CoinRepository{
        return CoinRepositoryImp(coinsApiInterface)

    }

    @Provides
    @Singleton
    fun provideUseCases(coinsApiInterface: CoinRepository): InvokeSortedCoins {
        return InvokeSortedCoins(coinsApiInterface)

    }


}