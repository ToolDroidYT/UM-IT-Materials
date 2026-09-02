    public Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data); // Correctly returns the new node
        }

        if (data < node.data) {
            // ISSUE: The result of the recursive call (which might be a new Node)
            // is stored in the local 'node' variable (the parameter),
            // but this does *not* update the 'left' pointer of the parent.
            node = insertNode(node.left, data); 
        } else if (data >= node.data) {
            // ISSUE: Same problem here for the 'right' pointer.
            node = insertNode(node.right, data);
        }

        // Returns the *original* 'node' (the root of the current subtree),
        // but its 'left' or 'right' child was never updated.
        return node; 
    }


    public Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            // FIX: Assign the result of the recursive call to the 'left' pointer.
            node.left = insertNode(node.left, data); 
        } else if (data >= node.data) {
            // FIX: Assign the result of the recursive call to the 'right' pointer.
            node.right = insertNode(node.right, data);
        }

        // Return the current node (the root of the current subtree), 
        // which now has its child pointers correctly updated.
        return node; 
    }
    