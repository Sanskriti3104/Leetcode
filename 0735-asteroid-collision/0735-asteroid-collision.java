class Solution {
    // Convert stack to array
    public int[] convertToArray(Stack<Integer> s) {
        return s.stream().mapToInt(Integer::intValue).toArray();
    }

    // Check if two asteroids have the same sign
    public boolean sameSign(int top, int[] asteroids, int idx) {
        return (top > 0 && asteroids[idx] > 0) || (top < 0 && asteroids[idx] < 0);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];

            // Handle asteroid collisions
            while (!s.isEmpty() && s.peek() > 0 && current < 0) {
                int top = s.peek();

                if (Math.abs(top) < Math.abs(current)) {
                    s.pop(); // Top asteroid is destroyed, continue checking
                } else if (Math.abs(top) == Math.abs(current)) {
                    s.pop(); // Both are destroyed
                    current = 0; // Mark current as destroyed
                    break;
                } else {
                    current = 0; // Current asteroid is destroyed
                    break;
                }
            }

            // Push asteroid if it wasn't destroyed
            if (current != 0) {
                s.push(current);
            }
        }

        return convertToArray(s);
    }
}
