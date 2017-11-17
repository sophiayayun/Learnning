package com.threadPool;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by dengyayun on 17/10/27.
 */
public class MylinkedQueue<E> extends AbstractQueue<E> implements myQueue<E>,Serializable{
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public Iterator<E> descendingIterator() {
        return null;
    }

    public void push(E e) {

    }

    public E pop() {
        return null;
    }

    public void addFirst(E e) {

    }

    public void addLast(E e) {

    }

    public boolean offerFirst(E e) {
        return false;
    }

    public boolean offerLast(E e) {
        return false;
    }

    public E removeFirst() {
        return null;
    }

    public E removeLast() {
        return null;
    }

    public E pollFirst() {
        return null;
    }

    public E pollLast() {
        return null;
    }

    public E getFirst() {
        return null;
    }

    public E getLast() {
        return null;
    }

    public E peekFirst() {
        return null;
    }

    public E peekLast() {
        return null;
    }

    public void putFirst(E e) throws InterruptedException {

    }

    public void putLast(E e) throws InterruptedException {

    }

    public boolean offerFirst(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public boolean offerLast(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public E takeFirst() throws InterruptedException {
        return null;
    }

    public E takeLast() throws InterruptedException {
        return null;
    }

    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    public void put(E e) throws InterruptedException {

    }

    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public E take() throws InterruptedException {
        return null;
    }

    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    public int remainingCapacity() {
        return 0;
    }

    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean offer(E e) {
        return false;
    }

    public E poll() {
        return null;
    }

    public E peek() {
        return null;
    }
}
