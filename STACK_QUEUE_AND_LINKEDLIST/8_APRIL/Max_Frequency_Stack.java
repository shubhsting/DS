// https://leetcode.com/problems/maximum-frequency-stack/
class FreqStack {
    HashMap<Integer, Stack<Integer>> frequencyToElements;
    HashMap<Integer, Integer> elementFrequency;
    int maxFrequency;

    public FreqStack() {
        frequencyToElements = new HashMap<>();
        elementFrequency = new HashMap<>();
        maxFrequency = 0;
    }

    public void push(int val) {
        elementFrequency.put(val, elementFrequency.getOrDefault(val, 0) + 1);
        int freq = elementFrequency.get(val);
        maxFrequency = Math.max(maxFrequency, freq);
        frequencyToElements.putIfAbsent(freq, new Stack<>());
        frequencyToElements.get(freq).push(val);
    }

    public int pop() {
        int element = frequencyToElements.get(maxFrequency).pop();
        elementFrequency.put(element, elementFrequency.getOrDefault(element, 0) - 1);
        if (frequencyToElements.get(maxFrequency).isEmpty())
            maxFrequency--;
        return element;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */