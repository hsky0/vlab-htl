
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct {
    int val;
    struct MyLinkedList* next;
} MyLinkedList;


MyLinkedList* myLinkedListCreate() {
    MyLinkedList *head = (MyLinkedList*)malloc(sizeof(MyLinkedList));
    head->next = NULL;
    return head;
}

int myLinkedListGet(MyLinkedList* obj, int index) {
    if(index < 0){
        return -1;
    }
    MyLinkedList *p = obj;
    while(index > 0){
        p = p->next;
        index--;
    }
    return !p ? -1 : p->val;
}

void myLinkedListAddAtHead(MyLinkedList* obj, int val) {
    
    MyLinkedList *node = (MyLinkedList*)malloc(sizeof(MyLinkedList));
    node->val = val;
    node->next = obj->next;
    obj->next = node;
}

void myLinkedListAddAtTail(MyLinkedList* obj, int val) {
    MyLinkedList *p = obj;
    while(p->next){
        p = p->next;
    }
    MyLinkedList *tail = (MyLinkedList*)malloc(sizeof(MyLinkedList));
    tail->val = val;
    tail->next = NULL;
    p->next = tail;
    
}

void myLinkedListAddAtIndex(MyLinkedList* obj, int index, int val) {
    if(index < 0){
        return;
    }
    if(index == 0){
        myLinkedListAddAtHead(obj, val);
        return;
    }
    MyLinkedList *p = obj->next;
    while(index > 1 && p){
        p = p->next;
        index--;
    }
    MyLinkedList *node = (MyLinkedList*)malloc(sizeof(MyLinkedList));
    node->val = val;
    node->next = p->next;
    p->next = node;

}

void myLinkedListDeleteAtIndex(MyLinkedList* obj, int index) {
    if(index < 0){
        return;
    }
    if(index == 0){
        MyLinkedList *tmp = obj->next;
        if (tmp != NULL){
            obj->next = tmp->next;
            free(tmp);     
        }
        return;
    }
    MyLinkedList *cur = obj->next;
    for(int i = 1; cur != NULL; i++){
        if(i == index){
            MyLinkedList* temp = cur->next;
            if(temp != NULL){
                cur->next = temp->next;
                free(temp);
            }
        } else{
            cur = cur->next;
        }
    }
    

}

void myLinkedListFree(MyLinkedList* obj) {
    MyLinkedList *p = obj;
    while(p){
        MyLinkedList *temp = p;
        p = p->next;
        free(temp);
    }

}

/**
 * Your MyLinkedList struct will be instantiated and called as such:
 * MyLinkedList* obj = myLinkedListCreate();
 * int param_1 = myLinkedListGet(obj, index);
 
 * myLinkedListAddAtHead(obj, val);
 
 * myLinkedListAddAtTail(obj, val);
 
 * myLinkedListAddAtIndex(obj, index, val);
 
 * myLinkedListDeleteAtIndex(obj, index);
 
 * myLinkedListFree(obj);
*/