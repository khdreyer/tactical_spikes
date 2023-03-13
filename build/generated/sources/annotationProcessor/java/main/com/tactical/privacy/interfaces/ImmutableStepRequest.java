package com.tactical.privacy.interfaces;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link StepRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableStepRequest.builder()}.
 */
@Generated(from = "StepRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableStepRequest implements StepRequest {
  private final int companyId;
  private final Identities identities;

  private ImmutableStepRequest(int companyId, Identities identities) {
    this.companyId = companyId;
    this.identities = identities;
  }

  /**
   * @return The value of the {@code companyId} attribute
   */
  @Override
  public int getCompanyId() {
    return companyId;
  }

  /**
   * @return The value of the {@code identities} attribute
   */
  @Override
  public Identities getIdentities() {
    return identities;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StepRequest#getCompanyId() companyId} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for companyId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStepRequest withCompanyId(int value) {
    if (this.companyId == value) return this;
    return new ImmutableStepRequest(value, this.identities);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StepRequest#getIdentities() identities} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for identities
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStepRequest withIdentities(Identities value) {
    if (this.identities == value) return this;
    Identities newValue = Objects.requireNonNull(value, "identities");
    return new ImmutableStepRequest(this.companyId, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableStepRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableStepRequest
        && equalTo(0, (ImmutableStepRequest) another);
  }

  private boolean equalTo(int synthetic, ImmutableStepRequest another) {
    return companyId == another.companyId
        && identities.equals(another.identities);
  }

  /**
   * Computes a hash code from attributes: {@code companyId}, {@code identities}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + companyId;
    h += (h << 5) + identities.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code StepRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("StepRequest")
        .omitNullValues()
        .add("companyId", companyId)
        .add("identities", identities)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link StepRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable StepRequest instance
   */
  public static ImmutableStepRequest copyOf(StepRequest instance) {
    if (instance instanceof ImmutableStepRequest) {
      return (ImmutableStepRequest) instance;
    }
    return ImmutableStepRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableStepRequest ImmutableStepRequest}.
   * <pre>
   * ImmutableStepRequest.builder()
   *    .companyId(int) // required {@link StepRequest#getCompanyId() companyId}
   *    .identities(com.tactical.privacy.interfaces.Identities) // required {@link StepRequest#getIdentities() identities}
   *    .build();
   * </pre>
   * @return A new ImmutableStepRequest builder
   */
  public static ImmutableStepRequest.Builder builder() {
    return new ImmutableStepRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableStepRequest ImmutableStepRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "StepRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder implements StepRequest.Builder {
    private static final long INIT_BIT_COMPANY_ID = 0x1L;
    private static final long INIT_BIT_IDENTITIES = 0x2L;
    private long initBits = 0x3L;

    private int companyId;
    private @Nullable Identities identities;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code StepRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(StepRequest instance) {
      Objects.requireNonNull(instance, "instance");
      companyId(instance.getCompanyId());
      identities(instance.getIdentities());
      return this;
    }

    /**
     * Initializes the value for the {@link StepRequest#getCompanyId() companyId} attribute.
     * @param companyId The value for companyId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder companyId(int companyId) {
      this.companyId = companyId;
      initBits &= ~INIT_BIT_COMPANY_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link StepRequest#getIdentities() identities} attribute.
     * @param identities The value for identities 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder identities(Identities identities) {
      this.identities = Objects.requireNonNull(identities, "identities");
      initBits &= ~INIT_BIT_IDENTITIES;
      return this;
    }

    /**
     * Builds a new {@link ImmutableStepRequest ImmutableStepRequest}.
     * @return An immutable instance of StepRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableStepRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableStepRequest(companyId, identities);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_COMPANY_ID) != 0) attributes.add("companyId");
      if ((initBits & INIT_BIT_IDENTITIES) != 0) attributes.add("identities");
      return "Cannot build StepRequest, some of required attributes are not set " + attributes;
    }
  }
}
