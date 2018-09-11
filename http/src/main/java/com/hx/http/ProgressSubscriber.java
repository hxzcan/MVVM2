package com.hx.http;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.Subject;

/**
 * Created by hexiao on 2018/8/8.
 */

public abstract class ProgressSubscriber<T> extends Subject<T> {

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onComplete() {
        _onComplete();
    }

    @Override
    public void onError(Throwable e) {
        _onError(e.getMessage().toString());
    }

    @Override
    public boolean hasObservers() {
        return false;
    }

    @Override
    public boolean hasThrowable() {
        return false;
    }
    @Override
    public boolean hasComplete() {
        return false;
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {

    }

    @Override
    public void onSubscribe(Disposable d) {

    }



    public abstract void _onNext(T t);

    public abstract void _onError(String error);

    public abstract void _onComplete();

}
