<template>
  <div class="neon-line-tracer">
    <svg viewBox="0 0 120 120" xmlns="http://www.w3.org/2000/svg">
      <!-- Slightly Smaller Hexagon -->
      <polygon class="tracer" points="60,10 105,35 105,85 60,110 15,85 15,35"></polygon>
    </svg>
    <span>Loading</span>
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
.neon-line-tracer {
  overflow: hidden;
  & span {
    color: white;
  }
  text-transform: uppercase;
  height: 83vh;
  width: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: center;
  text-align: center;
}

svg {
  width: 300px; /* Resized SVG for the hexagon */
  height: 300px;
}

.tracer {
  fill: none;
  color: white;
  stroke: #00ffff; /* Initial neon color: Cyan */
  stroke-width: 2;
  stroke-linejoin: round;
  stroke-dasharray: 320; /* Adjust for smaller hexagon perimeter */
  stroke-dashoffset: 320;
  animation: trace 2.5s ease-in-out infinite alternate, neonGlow 3s ease-in-out infinite;
}

/* Faster tracing animation */
@keyframes trace {
  0% {
    stroke-dashoffset: 320;
  }
  100% {
    stroke-dashoffset: 0;
  }
}

/* Neon glow cycling through colors */
@keyframes neonGlow {
  0% {
    stroke: #00ffff; /* Cyan */
  }
  33% {
    stroke: #ff00ff; /* Pink */
  }
  66% {
    stroke: #8000ff; /* Purple */
  }
  100% {
    stroke: #00ffff; /* Back to Cyan */
  }
}
</style>