package com.pratamawijaya.opendotaarchcomponent

/**
 * Created by pratama on 8/16/17.
 */

/**
 * A thread unsafe lazy function.
 * This function 'must' be called only on single thread.
 */
fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)
