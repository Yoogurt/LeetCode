use std::fmt::{Display, Formatter};
use core::fmt;
use std::borrow::Borrow;

pub struct ListNode {
    pub val: i32,
    pub next: Box<Option<ListNode>>,
}

pub fn build_list_node(data: Vec<i32>) -> Option<ListNode> {
    if data.is_empty() {
        return None;
    }

    let mut head = ListNode {
        val: data[0],
        next: Box::new(None),
    };


    let mut current = &mut head;
    for i in 1..data.len() {
        let mut new_node = ListNode {
            val: data[i],
            next: Box::new(None),
        };

        current.next = Box::new(Some(new_node));
        // current = current.next.as_ref().unwrap().as_mut();
    }

    return Some(head);
}

// impl std::ops::Drop for ListNode {
//     fn drop(&mut self) {
//         println!("dropping {}", self.val);
//         if self.next.is_some() {
//             unsafe {
//                 drop(self.next.unwrap());
//                 self.next = Box::new(None);
//             }
//         }
//     }
// }

impl Display for ListNode {
    fn fmt(&self, f: &mut Formatter<'_>) -> fmt::Result {
        if self.next.is_none() {
            write!(f, "ListNode(val:{})", self.val)
        } else {
            unsafe {
                write!(f, "ListNode(val:{} , next:{})", self.val, self.next.unwrap())
            }
        }
    }
}