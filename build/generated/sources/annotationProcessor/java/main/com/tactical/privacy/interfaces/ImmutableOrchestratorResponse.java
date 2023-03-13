package com.tactical.privacy.interfaces;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link OrchestratorResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableOrchestratorResponse.builder()}.
 */
@Generated(from = "OrchestratorResponse", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableOrchestratorResponse
    implements OrchestratorResponse {
  private final LocalDateTime startedAt;
  private final LocalDateTime endedAt;
  private final StepResponse[] stepResults;

  private ImmutableOrchestratorResponse(
      LocalDateTime startedAt,
      LocalDateTime endedAt,
      StepResponse[] stepResults) {
    this.startedAt = startedAt;
    this.endedAt = endedAt;
    this.stepResults = stepResults;
  }

  /**
   * @return The value of the {@code startedAt} attribute
   */
  @Override
  public LocalDateTime getStartedAt() {
    return startedAt;
  }

  /**
   * @return The value of the {@code endedAt} attribute
   */
  @Override
  public LocalDateTime getEndedAt() {
    return endedAt;
  }

  /**
   * @return A cloned {@code stepResults} array
   */
  @Override
  public StepResponse[] getStepResults() {
    return stepResults.clone();
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OrchestratorResponse#getStartedAt() startedAt} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for startedAt
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOrchestratorResponse withStartedAt(LocalDateTime value) {
    if (this.startedAt == value) return this;
    LocalDateTime newValue = Objects.requireNonNull(value, "startedAt");
    return new ImmutableOrchestratorResponse(newValue, this.endedAt, this.stepResults);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OrchestratorResponse#getEndedAt() endedAt} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for endedAt
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOrchestratorResponse withEndedAt(LocalDateTime value) {
    if (this.endedAt == value) return this;
    LocalDateTime newValue = Objects.requireNonNull(value, "endedAt");
    return new ImmutableOrchestratorResponse(this.startedAt, newValue, this.stepResults);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OrchestratorResponse#getStepResults() stepResults}.
   * The array is cloned before being saved as attribute values.
   * @param elements The non-null elements for stepResults
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOrchestratorResponse withStepResults(StepResponse... elements) {
    StepResponse[] newValue = elements.clone();
    return new ImmutableOrchestratorResponse(this.startedAt, this.endedAt, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableOrchestratorResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableOrchestratorResponse
        && equalTo(0, (ImmutableOrchestratorResponse) another);
  }

  private boolean equalTo(int synthetic, ImmutableOrchestratorResponse another) {
    return startedAt.equals(another.startedAt)
        && endedAt.equals(another.endedAt)
        && Arrays.equals(stepResults, another.stepResults);
  }

  /**
   * Computes a hash code from attributes: {@code startedAt}, {@code endedAt}, {@code stepResults}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + startedAt.hashCode();
    h += (h << 5) + endedAt.hashCode();
    h += (h << 5) + Arrays.hashCode(stepResults);
    return h;
  }

  /**
   * Prints the immutable value {@code OrchestratorResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("OrchestratorResponse")
        .omitNullValues()
        .add("startedAt", startedAt)
        .add("endedAt", endedAt)
        .add("stepResults", Arrays.toString(stepResults))
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link OrchestratorResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable OrchestratorResponse instance
   */
  public static ImmutableOrchestratorResponse copyOf(OrchestratorResponse instance) {
    if (instance instanceof ImmutableOrchestratorResponse) {
      return (ImmutableOrchestratorResponse) instance;
    }
    return ImmutableOrchestratorResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableOrchestratorResponse ImmutableOrchestratorResponse}.
   * <pre>
   * ImmutableOrchestratorResponse.builder()
   *    .startedAt(java.time.LocalDateTime) // required {@link OrchestratorResponse#getStartedAt() startedAt}
   *    .endedAt(java.time.LocalDateTime) // required {@link OrchestratorResponse#getEndedAt() endedAt}
   *    .stepResults(com.tactical.privacy.interfaces.StepResponse) // required {@link OrchestratorResponse#getStepResults() stepResults}
   *    .build();
   * </pre>
   * @return A new ImmutableOrchestratorResponse builder
   */
  public static ImmutableOrchestratorResponse.Builder builder() {
    return new ImmutableOrchestratorResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableOrchestratorResponse ImmutableOrchestratorResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "OrchestratorResponse", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder implements OrchestratorResponse.Builder {
    private static final long INIT_BIT_STARTED_AT = 0x1L;
    private static final long INIT_BIT_ENDED_AT = 0x2L;
    private static final long INIT_BIT_STEP_RESULTS = 0x4L;
    private long initBits = 0x7L;

    private @Nullable LocalDateTime startedAt;
    private @Nullable LocalDateTime endedAt;
    private @Nullable StepResponse[] stepResults;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code OrchestratorResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(OrchestratorResponse instance) {
      Objects.requireNonNull(instance, "instance");
      startedAt(instance.getStartedAt());
      endedAt(instance.getEndedAt());
      stepResults(instance.getStepResults());
      return this;
    }

    /**
     * Initializes the value for the {@link OrchestratorResponse#getStartedAt() startedAt} attribute.
     * @param startedAt The value for startedAt 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder startedAt(LocalDateTime startedAt) {
      this.startedAt = Objects.requireNonNull(startedAt, "startedAt");
      initBits &= ~INIT_BIT_STARTED_AT;
      return this;
    }

    /**
     * Initializes the value for the {@link OrchestratorResponse#getEndedAt() endedAt} attribute.
     * @param endedAt The value for endedAt 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder endedAt(LocalDateTime endedAt) {
      this.endedAt = Objects.requireNonNull(endedAt, "endedAt");
      initBits &= ~INIT_BIT_ENDED_AT;
      return this;
    }

    /**
     * Initializes the value for the {@link OrchestratorResponse#getStepResults() stepResults} attribute.
     * @param stepResults The elements for stepResults
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder stepResults(StepResponse... stepResults) {
      this.stepResults = stepResults.clone();
      initBits &= ~INIT_BIT_STEP_RESULTS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableOrchestratorResponse ImmutableOrchestratorResponse}.
     * @return An immutable instance of OrchestratorResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableOrchestratorResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableOrchestratorResponse(startedAt, endedAt, stepResults);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_STARTED_AT) != 0) attributes.add("startedAt");
      if ((initBits & INIT_BIT_ENDED_AT) != 0) attributes.add("endedAt");
      if ((initBits & INIT_BIT_STEP_RESULTS) != 0) attributes.add("stepResults");
      return "Cannot build OrchestratorResponse, some of required attributes are not set " + attributes;
    }
  }
}
