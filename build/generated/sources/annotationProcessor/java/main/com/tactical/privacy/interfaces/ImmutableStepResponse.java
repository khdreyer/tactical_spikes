package com.tactical.privacy.interfaces;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import com.tactical.privacy.models.StepStatus;
import com.tactical.privacy.models.StepType;
import java.time.LocalTime;
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
 * Immutable implementation of {@link StepResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableStepResponse.builder()}.
 */
@Generated(from = "StepResponse", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableStepResponse implements StepResponse {
  private final StepType stepType;
  private final StepStatus stepStatus;
  private final LocalTime startedAt;
  private final LocalTime endedAt;
  private final String[] messages;

  private ImmutableStepResponse(ImmutableStepResponse.Builder builder) {
    this.stepType = builder.stepType;
    this.stepStatus = builder.stepStatus;
    this.startedAt = builder.startedAt;
    this.endedAt = builder.endedAt;
    this.messages = builder.messages != null
        ? builder.messages
        : StepResponse.super.getMessages().clone();
  }

  private ImmutableStepResponse(
      StepType stepType,
      StepStatus stepStatus,
      LocalTime startedAt,
      LocalTime endedAt,
      String[] messages) {
    this.stepType = stepType;
    this.stepStatus = stepStatus;
    this.startedAt = startedAt;
    this.endedAt = endedAt;
    this.messages = messages;
  }

  /**
   * @return The value of the {@code stepType} attribute
   */
  @Override
  public StepType getStepType() {
    return stepType;
  }

  /**
   * @return The value of the {@code stepStatus} attribute
   */
  @Override
  public StepStatus getStepStatus() {
    return stepStatus;
  }

  /**
   * @return The value of the {@code startedAt} attribute
   */
  @Override
  public LocalTime getStartedAt() {
    return startedAt;
  }

  /**
   * @return The value of the {@code endedAt} attribute
   */
  @Override
  public LocalTime getEndedAt() {
    return endedAt;
  }

  /**
   * @return A cloned {@code messages} array
   */
  @Override
  public String[] getMessages() {
    return messages.clone();
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StepResponse#getStepType() stepType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for stepType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStepResponse withStepType(StepType value) {
    StepType newValue = Objects.requireNonNull(value, "stepType");
    if (this.stepType == newValue) return this;
    return new ImmutableStepResponse(newValue, this.stepStatus, this.startedAt, this.endedAt, this.messages);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StepResponse#getStepStatus() stepStatus} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for stepStatus
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStepResponse withStepStatus(StepStatus value) {
    StepStatus newValue = Objects.requireNonNull(value, "stepStatus");
    if (this.stepStatus == newValue) return this;
    return new ImmutableStepResponse(this.stepType, newValue, this.startedAt, this.endedAt, this.messages);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StepResponse#getStartedAt() startedAt} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for startedAt
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStepResponse withStartedAt(LocalTime value) {
    if (this.startedAt == value) return this;
    LocalTime newValue = Objects.requireNonNull(value, "startedAt");
    return new ImmutableStepResponse(this.stepType, this.stepStatus, newValue, this.endedAt, this.messages);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StepResponse#getEndedAt() endedAt} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for endedAt
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStepResponse withEndedAt(LocalTime value) {
    if (this.endedAt == value) return this;
    LocalTime newValue = Objects.requireNonNull(value, "endedAt");
    return new ImmutableStepResponse(this.stepType, this.stepStatus, this.startedAt, newValue, this.messages);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link StepResponse#getMessages() messages}.
   * The array is cloned before being saved as attribute values.
   * @param elements The non-null elements for messages
   * @return A modified copy of {@code this} object
   */
  public final ImmutableStepResponse withMessages(String... elements) {
    String[] newValue = elements.clone();
    return new ImmutableStepResponse(this.stepType, this.stepStatus, this.startedAt, this.endedAt, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableStepResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableStepResponse
        && equalTo(0, (ImmutableStepResponse) another);
  }

  private boolean equalTo(int synthetic, ImmutableStepResponse another) {
    return stepType.equals(another.stepType)
        && stepStatus.equals(another.stepStatus)
        && startedAt.equals(another.startedAt)
        && endedAt.equals(another.endedAt)
        && Arrays.equals(messages, another.messages);
  }

  /**
   * Computes a hash code from attributes: {@code stepType}, {@code stepStatus}, {@code startedAt}, {@code endedAt}, {@code messages}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + stepType.hashCode();
    h += (h << 5) + stepStatus.hashCode();
    h += (h << 5) + startedAt.hashCode();
    h += (h << 5) + endedAt.hashCode();
    h += (h << 5) + Arrays.hashCode(messages);
    return h;
  }

  /**
   * Prints the immutable value {@code StepResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("StepResponse")
        .omitNullValues()
        .add("stepType", stepType)
        .add("stepStatus", stepStatus)
        .add("startedAt", startedAt)
        .add("endedAt", endedAt)
        .add("messages", Arrays.toString(messages))
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link StepResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable StepResponse instance
   */
  public static ImmutableStepResponse copyOf(StepResponse instance) {
    if (instance instanceof ImmutableStepResponse) {
      return (ImmutableStepResponse) instance;
    }
    return ImmutableStepResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableStepResponse ImmutableStepResponse}.
   * <pre>
   * ImmutableStepResponse.builder()
   *    .stepType(com.tactical.privacy.models.StepType) // required {@link StepResponse#getStepType() stepType}
   *    .stepStatus(com.tactical.privacy.models.StepStatus) // required {@link StepResponse#getStepStatus() stepStatus}
   *    .startedAt(java.time.LocalTime) // required {@link StepResponse#getStartedAt() startedAt}
   *    .endedAt(java.time.LocalTime) // required {@link StepResponse#getEndedAt() endedAt}
   *    .messages(String) // optional {@link StepResponse#getMessages() messages}
   *    .build();
   * </pre>
   * @return A new ImmutableStepResponse builder
   */
  public static ImmutableStepResponse.Builder builder() {
    return new ImmutableStepResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableStepResponse ImmutableStepResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "StepResponse", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder implements StepResponse.Builder {
    private static final long INIT_BIT_STEP_TYPE = 0x1L;
    private static final long INIT_BIT_STEP_STATUS = 0x2L;
    private static final long INIT_BIT_STARTED_AT = 0x4L;
    private static final long INIT_BIT_ENDED_AT = 0x8L;
    private long initBits = 0xfL;

    private @Nullable StepType stepType;
    private @Nullable StepStatus stepStatus;
    private @Nullable LocalTime startedAt;
    private @Nullable LocalTime endedAt;
    private @Nullable String[] messages;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code StepResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(StepResponse instance) {
      Objects.requireNonNull(instance, "instance");
      stepType(instance.getStepType());
      stepStatus(instance.getStepStatus());
      startedAt(instance.getStartedAt());
      endedAt(instance.getEndedAt());
      messages(instance.getMessages());
      return this;
    }

    /**
     * Initializes the value for the {@link StepResponse#getStepType() stepType} attribute.
     * @param stepType The value for stepType 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder stepType(StepType stepType) {
      this.stepType = Objects.requireNonNull(stepType, "stepType");
      initBits &= ~INIT_BIT_STEP_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link StepResponse#getStepStatus() stepStatus} attribute.
     * @param stepStatus The value for stepStatus 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder stepStatus(StepStatus stepStatus) {
      this.stepStatus = Objects.requireNonNull(stepStatus, "stepStatus");
      initBits &= ~INIT_BIT_STEP_STATUS;
      return this;
    }

    /**
     * Initializes the value for the {@link StepResponse#getStartedAt() startedAt} attribute.
     * @param startedAt The value for startedAt 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder startedAt(LocalTime startedAt) {
      this.startedAt = Objects.requireNonNull(startedAt, "startedAt");
      initBits &= ~INIT_BIT_STARTED_AT;
      return this;
    }

    /**
     * Initializes the value for the {@link StepResponse#getEndedAt() endedAt} attribute.
     * @param endedAt The value for endedAt 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder endedAt(LocalTime endedAt) {
      this.endedAt = Objects.requireNonNull(endedAt, "endedAt");
      initBits &= ~INIT_BIT_ENDED_AT;
      return this;
    }

    /**
     * Initializes the value for the {@link StepResponse#getMessages() messages} attribute.
     * <p><em>If not set, this attribute will have a default value as defined by {@link StepResponse#getMessages() messages}.</em>
     * @param messages The elements for messages
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder messages(String... messages) {
      this.messages = messages.clone();
      return this;
    }

    /**
     * Builds a new {@link ImmutableStepResponse ImmutableStepResponse}.
     * @return An immutable instance of StepResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableStepResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableStepResponse(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_STEP_TYPE) != 0) attributes.add("stepType");
      if ((initBits & INIT_BIT_STEP_STATUS) != 0) attributes.add("stepStatus");
      if ((initBits & INIT_BIT_STARTED_AT) != 0) attributes.add("startedAt");
      if ((initBits & INIT_BIT_ENDED_AT) != 0) attributes.add("endedAt");
      return "Cannot build StepResponse, some of required attributes are not set " + attributes;
    }
  }
}
