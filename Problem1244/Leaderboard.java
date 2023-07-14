class Leaderboard {
    Map<Integer, Integer> scores;
    public Leaderboard() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        scores.put(
                playerId,
                scores.getOrDefault(playerId, 0) + score
        );
    }

    public int top(int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(
                        scores.get(a),
                        scores.get(b)
                )
        );

        for (int id : scores.keySet()) {
            pq.add(id);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int score = 0;
        while (!pq.isEmpty()) {
            score += scores.get(pq.poll());
        }

        return score;
    }

    public void reset(int playerId) {
        scores.remove(playerId);
    }
}
