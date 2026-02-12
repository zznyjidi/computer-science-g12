package tree;

public class BinaryTreeNode {
    public Integer value = null;
    public BinaryTreeNode left = null;
    public BinaryTreeNode right = null;

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{");

        builder.append("\"value\": " + value);
        if (left != null)
            builder.append(",\"left\":" + left.toString());
        if (right != null)
            builder.append(",\"right\":" + right.toString());

        builder.append("}");

        return builder.toString();
    }

    public int add(int value) {
        int opCount = 0;

        opCount++;
        if (this.value == null) {
            this.value = value;
            return opCount;
        }

        opCount++;
        if (this.value.equals(value)) {
            return opCount;
        }

        opCount++;
        if (value > this.value) {
            opCount++;
            if (this.right != null) {
                opCount += this.right.add(value);
            } else {
                opCount++;
                this.right = new BinaryTreeNode();
                this.right.value = value;
            }
        } else {
            opCount++;
            if (this.left != null) {
                opCount += this.left.add(value);
            } else {
                opCount++;
                this.left = new BinaryTreeNode();
                this.left.value = value;
            }
        }
        return opCount;
    }

    public int search(int value) {
        int opCount = 0;

        opCount++;
        if (this.value.equals(value))
            return opCount;

        opCount++;
        if (value < this.value) {
            opCount++;
            if (this.left != null) {
                opCount += this.left.search(value);
            }
        } else {
            opCount++;
            if (this.right != null) {
                opCount += this.right.search(value);
            }
        }

        return opCount;
    }
}
